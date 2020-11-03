def main():
    print("Input:")
    numberOfCases = input()
    while(not numberOfCases.isdigit()):
        print("ERROR: Bad Input!")
        numberOfCases = input()
    numberOfCases = int(numberOfCases)
    inputList = []  # list with inputs
    for i1 in range(0, numberOfCases):  # loop that appends inputs to list
        delimiters = input().split(" ")
        while not delimiters[0].isdigit() or not delimiters[1].isdigit() or int(delimiters[1]) < int(delimiters[0]):
            print("ERROR: Bad Input!")
            delimiters= input().split(" ")
        inputList.append(delimiters)

    print("Output:")

    for i2 in range(0, numberOfCases):
        n1= int(inputList[i2][0])
        n2= int(inputList[i2][1])
        maxDivisers= []
        for j in range(n1, n2+1):  # loop that goes for the number of loops to deal with each input
            diviser= 1
            maxDiviser= 1
            # while loop to get the maximum odd diviser of each number
            while diviser <= j:
                if (j % diviser == 0 and diviser % 2 != 0 and diviser > maxDiviser):
                    maxDiviser= diviser
                diviser += 1

            maxDivisers.append(maxDiviser)  # append maximum diviser to list

        # construction of print
        print(sum(maxDivisers), "(", end="")
        for i in range(0, len(maxDivisers)-1):
            print("%d+" % maxDivisers[i], end="")
        print("%d)" % maxDivisers[i+1])


if __name__ == "__main__":
    # execute only if run as a script
    main()
