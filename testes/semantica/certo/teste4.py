class Ponto:
    def __init__(self):
        self.x: float = None
        self.y: float = None


def main0():
    p = Ponto()
    p.x = 10.0
    p.y = 10.0
    print('(', end='')
    print(p.x, end='')
    print(',', end='')
    print(' ', end='')
    print(p.y, end='')
    print(')', end='')
    print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()