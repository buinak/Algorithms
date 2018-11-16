package statistics

class SortDataEntity(val sortName: String, val time: Int) : Comparable<SortDataEntity> {
    override fun compareTo(other: SortDataEntity): Int {
        return when {
            other.time > time -> -1
            other.time < time -> 1
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SortDataEntity

        if (sortName != other.sortName) return false

        return true
    }

    override fun hashCode(): Int {
        return sortName.hashCode()
    }

    override fun toString(): String {
        return "SortDataEntity(sortName='$sortName', time=$time)"
    }


}