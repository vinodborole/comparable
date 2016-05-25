# Comparable

Compares two different types of java POJO's by using java reflection.

# Usage
```
List<DiffUtil.Attribute> diffAttribute=DiffUtil.getDiff(sourcePojo, destinationPojo);

```

Here the difference is calculated with respect to destinationPojo.

# Logic

- If the number of fields is different; it will throw an Exception
- It considers collections while comparison
- If the collections are of type custom objects then those objects should implement equals() and hashCode() method for 
proper results. 


