# -*- coding: utf-8 -*-

import json


class MyClass:

    def __init__(self) -> None:
        super().__init__()
        self.key = 'a'
        self.value = 'b'


def to_json_str():
    myClass = MyClass('key', 'value')
    data = json.dumps(myClass.__dict__)
    print(type(data))
    print(data)


def to_json():
    param = {'key': 'key', 'value': 'value'}
    json_str = json.dumps(param)
    data = json.loads(json_str)
    print(type(data))
    print(data)
    print(data['key'])
    myClass = MyClass()
    myClass.__dict__ = data
    print(myClass.value)


# to_json_str()
to_json()
