# rxjava2-contacts
Android library to get contacts using RxJava2

# Usage
First add jitpack to your projects build.gradle file
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

Then add the dependency in modules build.gradle file
```gradle
dependencies {
    compile 'com.github.mirrajabi:rx-contacts2:1.2.0'
}
```

# Example

```java
RxContacts.fetch(this)
          .filter(m->m.getInVisibleGroup() == 1)
          .toSortedList(Contact::compareTo)
          .observeOn(Schedulers.io())
          .subscribeOn(AndroidSchedulers.mainThread())
          .subscribe(contacts -> {
              // Do something...
          });
```

## Using RxJava 1.x?
use the original library [https://github.com/UlrichRaab/rx-contacts](https://github.com/UlrichRaab/rx-contacts)
