class AtributosPersona:
    def __init__(self,altura,**kwargs):
        self.altura = altura
        self.peso = kwargs.get("peso", 0)
        self.gafas = kwargs.get("gafas", 3)


atributos = AtributosPersona(altura=30,peso=70,pepe=33)

print(atributos.peso)
print(atributos.gafas)