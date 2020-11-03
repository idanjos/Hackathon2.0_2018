def main():
    print("Input:")
    numberOfChildren = input()
    # input handling
    while (not numberOfChildren.isdigit()):
        print("ERROR: Bad Input!")
        numberOfChildren = input()
    numberOfChildren = int(numberOfChildren)

    childrens = {"V": [], "A": []}
    for i in range(0, numberOfChildren):
        children = input().split(" ")
        if(len(children) != 2):
            print("ERROR: Bad Input!")
            children = input().split(" ")
        childrens[children[1]].append(children[0])

    print("Output:")
    for color in sorted(childrens):
        for person in childrens[color]:
            print(person, color)


if __name__ == "__main__":
    # execute only if run as a script
    main()
