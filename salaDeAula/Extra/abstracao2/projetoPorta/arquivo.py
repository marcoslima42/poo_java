qtd = int(input())

letra = [chr(ord('a')+i) for i in range(qtd)]

for i in letra:
    for j in range(1, 5):
        with open(f"{i}i{j}.txt", 'w'):
            pass
        with open(f"{i}o{j}.txt", 'w'):
            pass
