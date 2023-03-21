# Práctica 1: Herencia, composición y polimorfismo

## Ejercicios propuestos

### Ejercicio 1

Dados los siguientes fragmentos de código, responder a las siguientes preguntas:

#### `ElementsSet.java`

```java
public class ElementsSet<E> extends HashSet<E> {
    //Number of attempted elements insertions using the "add" method
    private int numberOfAddedElements = 0;

    public ElementsSet() {}

    @Override
    public boolean add(E element) {
        numberOfAddedElements++; //Counting the element added
        return super.add(element);
    } 

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size(); //Counting the elements added
        return super.addAll(elements);
    } 

    public int getNumberOfAddedElements() {
        return numberOfAddedElements;
    }
}
```

#### `Main.java`

```java
    ...
    ElementsSet<String> set = new ElementsSet<String>();
    set.addAll(Arrays.asList("One", "Two", "Three"));
    System.out.println(set.getNumberOfAddedElements());
    ...
```

#### Preguntas propuestas

a) ¿Es el uso de la herencia adecuado para la implementación de la clase `ElementsSet`? ¿Qué salida muestra la función `System.out.println` al invocar el método `getNumberOfAddedElements`, 3 o 6?

No es adecuado, ya en caso de que se modifique la clase HashSet repercute directamente en la implementación de esta nueva clase. 

La salida que se muestra es **3** aunque el numero total de agregados es 3 + 2 + 1 = 6, la función **getNumberOfAddedElements** solo devuelve el número de elementos agregados mediante los métodos **add** y **addAll**, que en este caso es 3 como ya comentamos la salida.

b) En el caso de que haya algún problema en la implementación anterior, proponga una solución alternativa usando composición/delegación que resuelva el problema.

El único problema que podría ocurrir es que ante la modificación de los métodos **add** y **addAll** de la clase **HashSet**, el contador podría dejar de ser preciso. Para evitar este problema, podríamos usar composición/delegación en lugar de la herencia;

```csharp
    public class ElementsSet<E> {
    private HashSet<E> set = new HashSet<E>();
    private int numberOfAddedElements = 0;

    public ElementsSet() {}

    //modificador
    public boolean add(E element) {
        numberOfAddedElements++;
        return set.add(element);
    }

    //modificador
    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size();
        return set.addAll(elements);
    }

    //observador
    public int getNumberOfAddedElements() {
        return numberOfAddedElements;
    }

    // Observador
    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }
}
```

En lugar de extender de la clase, tenemos un objeto **HashSet** como miembro de instancia. Los métodos modificadores simplemente incrementan el contador y luego delegan el trabajo de agregar los elementos al objeto. Además se han añadido métodos para delegar cualquier otro método relevante de **HashSet**.

### Ejercicio 2

Dado los siguientes fragmentos de código responder a las siguientes preguntas:

#### `Animal.java`

```java
public abstract class Animal {
    //Number of legs the animal holds
    protected int numberOfLegs = 0;

    public abstract String speak();
    public abstract boolean eat(String typeOfFeed);
    public abstract int getNumberOfLegs();
}
```

#### `Cat.java`

```java
public class Cat extends Animal {
    @Override
    public String speak() {
        return "Meow";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("fish")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfLegs() {
        return super.numberOfLegs;
    }
}
```

#### `Dog.java`

```java
public class Dog extends Animal {
    @Override
    public String speak() {
        return "Woof";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("meat")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfLegs() {
        return super.numberOfLegs;
    }
}
```

#### `Main.java`

```java
    ...
    Animal cat = new Cat();
    Animal dog = new Dog();
    System.out.println(cat.speak());
    System.out.println(dog.speak());
    ...
```

#### Preguntas propuestas

a) ¿Es correcto el uso de herencia en la implementación de las clases `Cat` y `Dog`? ¿Qué beneficios se obtienen?

Sí, los beneficios de utilizar herencia en este caso son:

- Reutilización de código o código heredado, al extender de ña clase **Animal**, las clases **Cat** y **Dog** pueden reutilizar los métodos comunes que se definen en la clase **Animal**.

- Polimorfismo.

- Flexibilidad, si queremos agregar una nueva clase de animal, se puede extender la clase **Animal** y agregar la clase sin tener que volver a escribir el código común en la clase **Animal**.

b) En el caso de que el uso de la herencia no sea correcto, proponga una solución alternativa. ¿Cuáles son los beneficios de la solución propuesta frente a la original?

Es correcto, por lo que en este caso no daremos un ejemplo en el que se use la composición o delegación para lograr el mismo resultado.