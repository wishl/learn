# -*- coding: utf-8 -*-

from sqlalchemy import Column, BIGINT, INT, VARCHAR, create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base
import json


Base = declarative_base()


class User(Base):
    # 表名
    __tablename__ = 'tb_user'

    # 表结构
    id = Column(BIGINT(), primary_key=True)
    name = Column(VARCHAR(30))
    age = Column(INT())

    def __str__(self) -> str:
        return "id=" + str(self.id) + ",name=" + self.name + ",age=" + str(self.age)


def get_session():
    engine = get_engine()
    session = sessionmaker(bind=engine)
    return session


def get_engine():
    engine = create_engine("mysql+mysqlconnector://root:666666@localhost:3306/mysql_test")
    return engine


Dsession = get_session()


def insert():
    user = User(id=0, name='test', age='123')
    session = Dsession()
    try:
        session.add(user)
        session.commit()
    except Exception as e:
        print(e)
    finally:
        session.close()


def select():
    session = Dsession()
    result = session.query(User).filter(User.age >= 20).all()
    for i in range(result.__len__()):
        print(result[i])
    print(type(result))
    print(result)


def update():
    session = Dsession()
    result = session.query(User).filter(User.age >= 20).all()
    try:
        for i in range(result.__len__()):
            result[i].age = result[i].age - 1
            # if i == 2:
            #     1 / 0
        session.commit()
    except Exception as e:
        print(e)
        session.rollback()
    finally:
        session.close()


# 辣鸡方法
def delete():
    session = Dsession()
    result = session.query(User).filter(User.id >= 2).all()
    try:
        for i in range(result.__len__()):
            session.delete(result[i])
        session.commit()
    except Exception as e:
        print(e)
        session.rollback()
    finally:
        session.close()


# 批量删除
def delete_batch():
    session = Dsession()
    result = session.query(User).filter(User.id >= 2).delete()
    print(result)
    session.commit()


# 批量添加
def insert_batch():
    session = Dsession()
    # users = [{'id': 0, 'name': 'gmy%s' % i, 'age': i} for i in range(10)]
    list = []
    for i in range(3):
        user = User()
        user.age = 19 + i
        user.name = 'gmy%s' % i
        list.append(user)
    session.bulk_save_objects(list)
    session.commit()


# 批量添加（add_all）
def insert_batch2():
    session = Dsession()
    # users = [{'id': 0, 'name': 'gmy%s' % i, 'age': i} for i in range(10)]
    list = []
    for i in range(3):
        user = User()
        user.age = 19 + i
        user.name = 'gmy%s' % i
        list.append(user)
    session.add_all(list)
    session.commit()


# insert()
# select()
# update()
# delete_batch()
# insert_batch()
insert_batch2()
