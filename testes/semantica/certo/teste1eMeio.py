

def main0():
    n = 13
    q = 5
    w = divMod2(n, q)[1]
    z = ((2 * w) + 1)
    print('Z', end='')
    print(':', end='')
    print(z, end='')
    print('\n', end='')


def divMod2(n: int, q: int) -> tuple[int, int]:
    return ((division(n, q)), (n % q),)


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()