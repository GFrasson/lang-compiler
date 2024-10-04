

def f1(x: int):
    y = ((2 * x) + 1)
    print(y, end='')
    print('\n', end='')


def f2(x: int, z: int):
    y = ((2 * x) + z)
    print(y, end='')
    print('\n', end='')


def main0():
    f2(1, 2)
    f1(1)


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()