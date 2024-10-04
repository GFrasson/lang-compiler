

def main0():
    n = 13
    q = 5
    quo, res = divMod2(n, q) 
    print('Q', end='')
    print(':', end='')
    print(quo, end='')
    print('\n', end='')
    print('R', end='')
    print(':', end='')
    print(res, end='')
    print('\n', end='')


def divMod2(n: int, q: int) -> tuple[int, int]:
    return ((division(n, q)), (n % q),)


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()