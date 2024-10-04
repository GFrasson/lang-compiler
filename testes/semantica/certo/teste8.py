

def fat1(n: int) -> tuple[int]:
    if (n == 0):
        return (1,)

    return ((n * fat1((n - 1))[0]),)


def spook1(n: int) -> tuple[int]:
    if (n == 1):
        return ((2 * n),)

    if (n == 2):
        return (((2 * n) + 1),)

    return ((n - 1),)


def main0():
    k = fat1(6)[0]
    k = spook1(2)[0]
    print(k, end='')
    print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()