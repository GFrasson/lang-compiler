

def main0():
    nlines = 5
    for _ in range(nlines):
        i = nlines
        for _ in range(i):
            print('*', end='')
        nlines = (nlines - 1)
        print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()