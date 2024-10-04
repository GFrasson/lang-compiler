

def f1(x: int) -> tuple[int, float]:
    y = ((2 * x) + 1)
    if (y < 10):
        return (y, 1.5,)
    else:
        return (y, 1.5,)



def main0():
    z = f1(10)[1]
    h = (2 * f1(10)[0])


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()