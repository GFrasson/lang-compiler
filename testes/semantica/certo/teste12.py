

def even1(n: int) -> tuple[bool]:
    if (n == 0):
        return (True,)
    else:
        return (odd1((n - 1))[0],)



def odd1(n: int) -> tuple[bool]:
    if (n == 0):
        return (False,)
    else:
        return (even1((n - 1))[0],)



def main0():
    r = even1(3)[0]
    if r:
        print('P', end='')
        print('A', end='')
        print('R', end='')
    else:
        print('I', end='')
        print('M', end='')
        print('P', end='')
        print('A', end='')
        print('R', end='')



def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()