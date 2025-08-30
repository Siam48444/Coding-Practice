import matplotlib.pyplot as plt
import numpy as np

# Math fonts
plt.rcParams['font.family'] = 'KaTeX_Main'
plt.rcParams['mathtext.fontset'] = 'cm'



def main():
    x = [i for i in range(50)]
    y = [fib_binet(n) for n in x]

    fig, ax = plt.subplots()     
    ax.plot(x, y, marker="o", linestyle="-", color="red")

    ax.set_title("Fibonacci Numbers via Binet's Formula", fontsize=16)
    ax.set_xlabel(r"$n$", fontsize=14)
    ax.set_ylabel(r"$F_n$", fontsize=14)

    ax.grid(True)
    plt.show()         



def fib(lim):
    if lim <= 0:
        return []

    f1, f2 = 1, 1 
    res = [f1, f2]
    for n in range(lim-2):
        res.append(res[-1] + res[-2])
    return res



def fib_binet(n):
    phi = (1 + np.sqrt(5)) / 2
    psi = (1 - np.sqrt(5)) / 2
    return (phi**n - psi**n) / np.sqrt(5)





if __name__ == "__main__":
    main()