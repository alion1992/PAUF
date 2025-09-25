class Edificio:
    def __init__(self,nombre,**kwargs):
        self.nombre = nombre
        self.puertas = kwargs.get("puertas",0)
        self.ventanas = kwargs.get("ventanas", None)


edificio = Edificio("edificio mayor", puertas=20)
if edificio.ventanas:
    print("tiene ventanas")
else:
    print("No tiene")

