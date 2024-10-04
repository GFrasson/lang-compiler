

def main0():
    x = 0
    print('>', end='')
    x = input()
    print(x, end='')
    print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()