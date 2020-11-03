# calculates all the fibonacci numbers smaller than the specified number
def calculateFibbonaciNumbers(number, fibList):
    nextFibNumber = fibList[-1]+fibList[-2]
    while (nextFibNumber < number):
        fibList.append(nextFibNumber)
        nextFibNumber = fibList[-1]+fibList[-2]


def getMinimumSubsetFibNumbersToSum(number, fibList):
    count = 0
    fibSubset = []
    lastIndex = len(fibList)-1  # get index of last calculated fibonacci number
    while(number > 0):
        temp = count
        # floor division, if value of counter alters, number is part of sum
        count += number // fibList[lastIndex]
        if (count != temp):  # if this verifies, it was found another number of the sum and we stored this number
            fibSubset.append(fibList[lastIndex])
        number %= fibList[lastIndex]  # subtract origin number with a modulo
        lastIndex -= 1
    return fibSubset


def main():
    number = input("Input: ")
    while (not number.isdigit() or int(number) <= 2):
        number = input(
            "Error: Input should be a positive integer greater than 2.\nInput: ")
    number = int(number)
    fibonacciNumbers = [1, 1, 2]
    calculateFibbonaciNumbers(number, fibonacciNumbers)
    fibSubsetSum = getMinimumSubsetFibNumbersToSum(number, fibonacciNumbers)
    print("Output:", end="")
    for number in sorted(fibSubsetSum):
        print("", number, end="")
    print()


if __name__ == "__main__":
    # execute only if run as a script
    main()
