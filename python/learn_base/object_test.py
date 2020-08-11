# -*- coding: utf-8 -*-


class Employee:

    def __init__(self, name: str, salary: float, position: int) -> None:
        self.name = name
        self.salary = salary
        self.position = position

    def get_name(self) -> str:
        return self.name


class Boss(Employee):

    def __init__(self, name: str, salary: float, position: int) -> None:
        super().__init__(name, salary, position)

    def get_name(self):
        return self.name

    def fire_with(self, employee) -> bool:
        if employee.position is None or \
                employee.position > self.position:
            return False
        return True


boss = Boss('gmy', 100, 10)
employee = Employee('jbw', 50, 1)
flag = boss.fire_with(employee)
print(flag)
