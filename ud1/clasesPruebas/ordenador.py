class Ordenador:
    def __init__(self, grafica,cpu,refrigeracion, **kwargs):
        self.__grafica = grafica
        self.__cpu = cpu
        self.__refrigeracion = refrigeracion

    @property
    def grafica(self):
        return self.__grafica

    @grafica.setter
    def grafica(self, value):
        self.__grafica = value

ordenador = Ordenador(grafica="RTX 4090",cpu="x", refrigeracion="Y")

ordenador.cpu = 20
ordenador.__cpu = 40
print(ordenador.cpu)
print(ordenador.grafica)
ordenador.grafica = 30

print(ordenador.__dict__)


