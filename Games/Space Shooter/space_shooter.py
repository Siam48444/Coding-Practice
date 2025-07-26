import pygame


pygame.init()
WINDOW_WIDTH, WINDOW_HEIGHT = 800, 800
WINDOW = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))



def main():
    running = True

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
                
    





if __name__ == "__main__":
    main()