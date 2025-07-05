class LogicalExpressions:
    def __init__(self, *args):
        self.args = list(args)

    def symbol(self):
        '''Abstract method to return the operator symbol (e.g., AND, OR, NOT)'''
        raise NotImplementedError("Subclasses must define a symbol.")

    def add(self, *args):
        '''Add more operands to the current expression'''
        self.args.extend(args)

    def formula(self):
        '''Generate a string representation of the logical expression'''
        parts = []
        for arg in self.args:
            if isinstance(arg, LogicalExpressions):
                if self.symbol() == arg.symbol() or isinstance(arg, Not):
                    parts.append(f"{arg.formula()}")
                else:
                    parts.append(f"({arg.formula()})")
            else:
                parts.append(f"{arg}")
        return f"{self.symbol()}".join(parts)

    def evaluate(self, **kwargs):
        '''Abstract method to evaluate the expression based on variable values'''
        raise NotImplementedError("Subclasses must implement evaluate.")


class And(LogicalExpressions):
    def __init__(self, *args):
        if len(args) < 2:
            raise ValueError(f"{self.__class__.__name__} class must have at least two operands.")
        super().__init__(*args)

    def symbol(self):
        '''Return the symbol for logical AND'''
        return " ∧ "

    def evaluate(self, **kwargs):
        '''Evaluate all operands using logical AND'''
        return all(
            arg.evaluate(**kwargs) if isinstance(arg, LogicalExpressions) else kwargs[arg] for arg in self.args
        )


class Or(LogicalExpressions):
    def __init__(self, *args):
        if len(args) < 2:
            raise ValueError(f"{self.__class__.__name__} class must have at least two operands.")
        super().__init__(*args)

    def symbol(self):
        '''Return the symbol for logical OR'''
        return " ∨ "

    def evaluate(self, **kwargs):
        '''Evaluate all operands using logical OR'''
        return any(
            arg.evaluate(**kwargs) if isinstance(arg, LogicalExpressions) else kwargs[arg] for arg in self.args
        )


class Implication(LogicalExpressions):
    def __init__(self, *args):
        if len(args) != 2:
            raise ValueError(f"{self.__class__.__name__} class must have exactly two operands.")
        super().__init__(*args)

    def symbol(self):
        '''Return the symbol for logical implication'''
        return " -> "

    def evaluate(self, **kwargs):
        '''Evaluate implication: A → B is equivalent to ¬A ∨ B'''
        left = self.args[0]
        right = self.args[1]

        left_val = left.evaluate(**kwargs) if isinstance(left, LogicalExpressions) else kwargs[left]
        right_val = right.evaluate(**kwargs) if isinstance(right, LogicalExpressions) else kwargs[right]

        return (not left_val) or right_val


class Biconditional(LogicalExpressions):
    def __init__(self, *args):
        if len(args) != 2:
            raise ValueError(f"{self.__class__.__name__} class must have exactly two operands.")
        super().__init__(*args)

    def symbol(self):
        '''Return the symbol for logical biconditional'''
        return " <-> "

    def evaluate(self, **kwargs):
        '''Evaluate biconditional: True if both operands are equal'''
        left = self.args[0]
        right = self.args[1]

        left_val = left.evaluate(**kwargs) if isinstance(left, LogicalExpressions) else kwargs[left]
        right_val = right.evaluate(**kwargs) if isinstance(right, LogicalExpressions) else kwargs[right]

        return left_val == right_val


class Not(LogicalExpressions):
    def __init__(self, *args):
        if len(args) != 1:
            raise ValueError("NOT operator must have exactly one operand.")
        super().__init__(*args)

    def symbol(self):
        '''Return the symbol for logical NOT'''
        return "¬"

    def formula(self):
        '''Return the string representation for NOT'''
        parts = []
        for arg in self.args:
            if isinstance(arg, LogicalExpressions):
                parts.append(f"{self.symbol()}({arg.formula()})")
            else:
                parts.append(f"{self.symbol()}{arg}")
        return parts[0]

    def evaluate(self, **kwargs):
        '''Evaluate logical NOT on a single operand'''
        arg = self.args[0]
        val = arg.evaluate(**kwargs) if isinstance(arg, LogicalExpressions) else kwargs[arg]
        return not val




expr = And("A", "B")
print(expr.formula())

result = expr.evaluate(A=True, B=True)
print(result)