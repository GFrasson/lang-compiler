

def main0():
    x = 1
    y = 2
    z = 3
    maior = x
    if (x < y):
        if (y < z):
            maior = z
        else:
            maior = y

    else:
        if (x < z):
            maior = z
        else:
            maior = x


    print('M', end='')
    print('a', end='')
    print('i', end='')
    print('o', end='')
    print('r', end='')
    print(':', end='')
    print(' ', end='')
    print(maior, end='')
    print('\n', end='')


def division(a, b):
    return a // b if isinstance(a, int) else a / b


if __name__ == '__main__':
    main0()