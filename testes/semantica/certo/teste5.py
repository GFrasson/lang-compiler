class Ponto:
    def __init__(self):
        self.x: int = None
        self.y: int = None


def main0():
    k = 5
    p = list(None for _ in range(k))
    i = 0
    for _ in range(k):
        p[i] = Ponto()
        p[i].x = (12 + i)
        p[i].y = (12 - i)
        print(p[i].y, end='')
        print('\n', end='')
        i = (i + 1)
    print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()