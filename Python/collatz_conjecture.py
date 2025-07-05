import matplotlib.pyplot as plt


def collatzSequence(n: int) -> list:
    '''Returns the Collatz sequence starting from n.'''
    if n <= 0: raise ValueError('n must be a positive integer')
    sequence = [n]
    while n != 1:
        n = n // 2 if n % 2 == 0 else 3 * n + 1
        sequence.append(n)
    return sequence


def collatzStepCount(n: int) -> int:
    '''Returns the number of steps it takes for n to reach 1.'''
    if n <= 0: raise ValueError('n must be a positive integer')
    steps = 0
    while n != 1:
        n = n // 2 if n % 2 == 0 else 3 * n + 1
        steps += 1
    return steps


def collatzMaxValue(n: int) -> int:
    '''Returns the highest value in the Collatz sequence starting from n.'''
    if n <= 0: raise ValueError('n must be a positive integer')
    maxVal = n
    while n != 1:
        n = n // 2 if n % 2 == 0 else 3 * n + 1
        maxVal = max(maxVal, n)
    return maxVal


# Plot Formatting Variables
figuresize = (13, 7)
titleFontSize = 18
labelFontSize = 12
ticksFontSize = 10

def plotCollatzSequence(seeds: list) -> None:
    '''Plots Collatz sequence(s) for each starting number.'''
    # Create figure
    plt.figure(figsize=figuresize)
    for n in seeds:
        sequence = collatzSequence(n)
        steps = list(range(len(sequence)))
        plt.plot(steps, sequence, label=f'{n}')

    if len(seeds) == 1:
        maxValue = max(sequence)
        minValue = min(sequence)
        maxIndex = sequence.index(maxValue)
        minIndex = sequence.index(minValue)
        plt.annotate(f'Max: {maxValue}', xy=(maxIndex, maxValue), fontsize=ticksFontSize)
        plt.annotate(f'Min: {minValue}', xy=(minIndex, minValue), fontsize=ticksFontSize)
        plt.title(f'Collatz Sequence Starting from {seeds[0]}', fontsize=titleFontSize)
    else:
        plt.title(f'Collatz Sequences', fontsize=titleFontSize)

    labelX = f'Number of Steps {"= " + str(len(sequence) - 1) if len(seeds) == 1 else ""}'
    plt.xlabel(labelX, fontsize=labelFontSize)
    plt.ylabel('Value', fontsize=labelFontSize)
    plt.xticks(fontsize=ticksFontSize)
    plt.yticks(fontsize=ticksFontSize)
    # plt.legend(fontsize=ticksFontSize)  # optional
    plt.grid(True)
    plt.show()


def plotCollatzStepCount(seeds: list) -> None:
    '''Plots the number of steps in the Collatz sequence for each starting number.'''
    # Create figure
    plt.figure(figsize=figuresize)
    for n in seeds:
        stepCount = collatzStepCount(n)
        plt.plot(n, stepCount, marker='o', markersize=4, linestyle='', color='red')

    if len(seeds) == 1:
        plt.title(f'Number of Steps in the Collatz Sequence Starting from {seeds[0]}', fontsize=titleFontSize)
    else:
        plt.title(f'Number of Steps in the Collatz Sequences', fontsize=titleFontSize)

    plt.xlabel('Starting Number', fontsize=labelFontSize)
    plt.ylabel('Steps to Reach 1', fontsize=labelFontSize)
    plt.xticks(fontsize=ticksFontSize)
    plt.yticks(fontsize=ticksFontSize)
    plt.grid(True)
    plt.show()


def plotCollatzMaxValue(seeds: list) -> None:
    '''Plots the maximum value reached in the Collatz sequence for each starting number.'''
    # Create figure
    plt.figure(figsize=figuresize)
    for n in seeds:
        maxVal = collatzMaxValue(n)
        plt.plot(n, maxVal, marker='o', markersize=4, linestyle='', color='red')

    if len(seeds) == 1:
        plt.title(f'Max Value Reached in the Collatz Sequence Starting from {seeds[0]}', fontsize=titleFontSize)
    else:
        plt.title(f'Max Value Reached in Collatz Sequences', fontsize=titleFontSize)

    plt.xlabel('Starting Number', fontsize=labelFontSize)
    plt.ylabel('Max Value Reached', fontsize=labelFontSize)
    plt.xticks(fontsize=ticksFontSize)
    plt.yticks(fontsize=ticksFontSize)
    plt.grid(True)
    plt.show()





plotCollatzSequence([27])