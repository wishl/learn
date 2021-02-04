
import requests
import threading


def mutil_thread_test():
    host = "https://mobile2.baidu.com:443/eye-web/service/registerService/sendSms"
    data = {"telephone": "18518137760", "time": 1610715255161}
    res = requests.post(host, json=data, verify=False).json()
    print(res)


def run():
    thread_list = []
    for i in range(25):
        t = threading.Thread(target=mutil_thread_test)
        thread_list.append(t)
    for t in thread_list:
        t.start()
    for t in thread_list:
        t.join()


run()
