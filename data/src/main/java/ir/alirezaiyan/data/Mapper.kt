package ir.alirezaiyan.data

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 6:34 PM.
 */
interface Mapper<T, out R> {
    fun map(from: T): R

    fun map(fromList: List<T>) = fromList.map { map(it) }
}