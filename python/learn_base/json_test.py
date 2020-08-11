# -*- coding: utf-8 -*-

import json


def to_json_str():
    param = {'key': 'value', 'key2': 'value2'}
    data = json.dumps(param)
    print(type(data))
    print(data)


def to_json():
    param = {'key': 'value', 'key2': 'value2'}
    json_str = json.dumps(param)
    data = json.loads(json_str)
    print(type(data))
    print(data)
    print(data['key'])


# to_json_str()
to_json()
