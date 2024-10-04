class Ponto:
    def __init__(self):
        self.x: int = None
        self.y: int = None


def printP1(p: Ponto):
    print('(', end='')
    print(p.x, end='')
    print(',', end='')
    print(p.y, end='')
    print(')', end='')


def printV2(v: list[Ponto], n: int):
    print('{', end='')
    if (0 < n):
        printP1(v[0])
        i = 1
        for _ in range((n - 1)):
            print(',', end='')
            printP1(v[i])
            i = (i + 1)

    print('}', end='')


def sort2(v: list[Ponto], n: int):
    i = 0
    for _ in range((n - 1)):
        j = (i + 1)
        for _ in range((n - (i + 1))):
            if (v[i].x < v[j].x):
                aux = v[i]
                v[i] = v[j]
                v[j] = aux

            j = (j + 1)
        i = (i + 1)


def main0():
    k = 5
    p = list(None for _ in range(k))
    i = 0
    for _ in range(k):
        p[i] = Ponto()
        p[i].x = (12 + i)
        p[i].y = (12 - i)
        i = (i + 1)
    printV2(p, k)
    sort2(p, k)
    print('\n', end='')
    printV2(p, k)
    print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()