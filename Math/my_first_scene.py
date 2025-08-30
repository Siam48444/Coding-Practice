from manim import *

class SquareToCircle(Scene):
    def construct(self):
        square = Square()          # Create a square
        circle = Circle()          # Create a circle
        
        self.play(Create(square))  # Animate drawing the square
        self.play(Transform(square, circle))  # Morph square into circle
        self.play(FadeOut(square)) # Fade out