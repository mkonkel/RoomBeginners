import mkonkel.com.room.database.entity.user.User

fun User?.formatToString() = this?.let {
    "${it.id} \n ${it.firstName} \n ${it.lastName} \n ${it.fullName} \n ${it.birthday} \n" +
            "${it.homeAddress?.city}, ${it.homeAddress?.street}, ${it.homeAddress?.postal} \n" +
            "${it.officeAddress?.city}, ${it.officeAddress?.street}, ${it.officeAddress?.postal} \n" +
            "${it.emailAddress} \n ${it.phoneNumber} \n ${it.picture}"
} ?: ""
