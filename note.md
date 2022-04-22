### 实体类中不要使用基本类型
基本类型包括：byte int short long float double char boolean
由于 java 中的基本类型有默认值，某些情况下不能使属性为 null。并且在动态 SQL 的部分，如果使用 != null 进行判断，结果总会为 true，因而会导致很多隐藏的问题。

### MyBatis XML 使用
使用 MyBatis 的接口不等于使用 MyBatis 注解，这两者是不同的。
接口可以配合 XML 使用，也可以配合注解来使用。XML 可以单独使用，但是注解必须在接口中使用。

### 名称映射规则
可以通过在 resultMap 中配置 property 属性和 column 属性的映射，或者在 SQL 中设置别名这两种方式实现将查询列映射到对象属性的目的。

property 属性或别名要和对象中属性的名字相同，但是实际匹配时，MyBatis 会现将两者都转换为大写形式，然后再判断是否相同，因此在设置 property 属性或别名的时候，不需要考虑大小写是否一致，但是为了便于阅读，要尽可能按照统一的规则来设置。