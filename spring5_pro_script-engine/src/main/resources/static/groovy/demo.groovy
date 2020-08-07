class Singer {
    def firstName;
    def lastName;
    def birthDay;

    String toString() {
        "($firstName, $lastName, $birthDay)"
    }
}

Singer singer = new Singer(
        firstName: 'John',
        lastName: 'Mayer',
        birthDay: new Date(
                new GregorianCalendar(1977, 9, 16)
                        .getTime().getTime())
)

Singer anotherSinger = new Singer(
        firstName: 39,
        lastName: 'Mayer',
        birthDay: new Date(
                new GregorianCalendar(1977, 9, 16)
                        .getTime().getTime())
)

println singer
println anotherSinger
println singer.firstName + 39
println anotherSinger.firstName + 39

def list = ['This', 'is', 'John Mayer']

println list

assert list.size() == 3
assert list.class == ArrayList
assert list.reverse() == ['John Mayer', 'is', 'This']
assert list.sort{it.size()} == ['is', 'This', 'John Mayer']
assert list[0..1] == ['is', 'This']

list = ['a': 10, 'b': 50]
Closure square = {key, value -> list[key] = value * value}
list.each square
println list