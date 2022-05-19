package www.onbeatapps.com.data.model.api.response


import com.google.gson.annotations.SerializedName

data class test(
    @SerializedName("address")
    val address: Any,
    @SerializedName("anonymous")
    val anonymous: Boolean,
    @SerializedName("balances")
    val balances: Balances,
    @SerializedName("birthdate")
    val birthdate: Any,
    @SerializedName("card")
    val card: List<Card>,
    @SerializedName("city")
    val city: Any,
    @SerializedName("country")
    val country: Any,
    @SerializedName("email")
    val email: Any,
    @SerializedName("family_id")
    val familyId: Any,
    @SerializedName("family_owner")
    val familyOwner: Boolean,
    @SerializedName("first_name")
    val firstName: Any,
    @SerializedName("gender")
    val gender: Any,
    @SerializedName("global_refundable_money")
    val globalRefundableMoney: String,
    @SerializedName("gtags")
    val gtags: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("money")
    val money: Int,
    @SerializedName("orders")
    val orders: List<Order>,
    @SerializedName("phone")
    val phone: Any,
    @SerializedName("postcode")
    val postcode: Any,
    @SerializedName("refundable")
    val refundable: Boolean,
    @SerializedName("tickets")
    val tickets: List<Ticket>,
    @SerializedName("virtual_money")
    val virtualMoney: Int
) {
    data class Balances(
        @SerializedName("534")
        val x534: String,
        @SerializedName("535")
        val x535: String
    )

    data class Card(
        @SerializedName("card_type")
        val cardType: String,
        @SerializedName("last_four")
        val lastFour: String,
        @SerializedName("payment_method_id")
        val paymentMethodId: String
    )

    data class Order(
        @SerializedName("completed_at")
        val completedAt: String,
        @SerializedName("customer_id")
        val customerId: Int,
        @SerializedName("description")
        val description: Any,
        @SerializedName("gateway")
        val gateway: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("money_base")
        val moneyBase: String,
        @SerializedName("money_fee")
        val moneyFee: String,
        @SerializedName("status")
        val status: String
    )

    data class Ticket(
        @SerializedName("banned")
        val banned: Boolean,
        @SerializedName("code")
        val code: String,
        @SerializedName("customer_id")
        val customerId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("redeemed")
        val redeemed: Boolean,
        @SerializedName("ticket_type_id")
        val ticketTypeId: Int
    )
}