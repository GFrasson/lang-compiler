class Square:
    def __init__(self):
        self.points: list[Point] = None


class Point:
    def __init__(self):
        self.x: int = None
        self.y: int = None


def soma2(x: int, y: int) -> tuple[int]:
    return ((x + y),)


def soma1(x: int) -> tuple[int]:
    return ((x + 1),)


def somaEMultiplica2(x: int, y: int) -> tuple[int, int]:
    return ((x + y), (x * y),)


def procedimento1(x: int):
    print('p', end='')
    print(x, end='')


def main0():
    square = Square()
    size = 10
    square.points = list(None for _ in range(size))
    i = 0
    for _ in range(size):
        square.points[i] = Point()
        i = (i + 1)
    square.points[5].x = 1
    print(square.points[5].x, end='')
    procedimento1(10)
    print(soma1(10)[0], end='')
    print(soma2(6, 6)[0], end='')
    a, b = somaEMultiplica2(7, 7) 
    print(a, end='')
    print('\n', end='')
    print(b, end='')


if __name__ == '__main__':
    main0()