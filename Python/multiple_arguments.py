from termcolor import cprint


def print_shopping_list(*items, **kwargs) -> None:
    store = kwargs.get("store")
    budget = kwargs.get("budget")
    prices = kwargs.get("prices", {})

    if store:
        cprint(f"Shopping at: {store}", "green")
    if budget:
        cprint(f"Budget: ${budget}", "green")

    print("Items to buy:")
    total = 0
    for i, item in enumerate(items):
        quantity = kwargs.get(item, 1)
        price = prices.get(item, 0)
        cost = quantity * price
        total += cost
        print(f"   {i+1}. {item.capitalize()} [×{quantity}] --> ${price} each = ${cost}")
        if not price:
            cprint(f"      No price specified for {item}.", "red")
    print(f"Total cost: ${total}")

    if budget and total > budget:
        cprint(f"* Warning: Insufficient budget! More needed: ${total - budget}", "red")
    print("-" * 40)


def summation(*numbers):
    total = 0
    for num in numbers:
        try:
            n = float(num)
        except:
            raise ValueError(f"Invalid number: {repr(num)}")
        total += n
    return total