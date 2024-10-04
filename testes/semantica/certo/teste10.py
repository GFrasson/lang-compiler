

def fibonacci1(n: int) -> tuple[int]:
    if (n < 1):
        return (n,)

    if (n == 1):
        return (n,)

    return ((fibonacci1((n - 1))[0] + fibonacci1((n - 2))[0]),)


def main0():
    v = fibonacci1(5)[0]
    print(v, end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()