package com.example.phonebook.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.phonebook.data.Contact
import com.example.phonebook.data.ContactsRepository
import java.text.NumberFormat

class ItemEntryViewModel(private val contactsRepository: ContactsRepository) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            contactsRepository.insertContact(itemUiState.itemDetails.toItem())
        }
    }

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && surname.isNotBlank()
        }
    }
}

data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val number: String = "",
)

fun ItemDetails.toItem(): Contact = Contact(
    id = id,
    name = name,
    surname = surname,
    number = number.toLongOrNull() ?: 0
)


fun Contact.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

fun Contact.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    surname = surname,
    number = number.toString()
)
