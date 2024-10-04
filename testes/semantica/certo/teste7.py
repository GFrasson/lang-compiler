

def main0():
    k = 5
    x = list(None for _ in range(k))
    i = 0
    for _ in range(k):
        x[i] = list(None for _ in range(k))
        i = (i + 1)
    i = 0
    for _ in range(k):
        x[i][i] = ((2 * i) + 1)
        i = (i + 1)
    z = x[3][3]


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()