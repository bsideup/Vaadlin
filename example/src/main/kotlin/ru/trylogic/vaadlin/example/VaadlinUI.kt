package ru.trylogic.vaadlin.example

import com.vaadin.annotations.Theme
import com.vaadin.server.FontAwesome
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Notification
import com.vaadin.ui.UI
import com.vaadin.ui.themes.ValoTheme
import ru.trylogic.vaadlin.*

@SpringUI
@Theme(ValoTheme.THEME_NAME)
class VaadlinUI : UI() {
    override fun init(request: VaadinRequest?) = setContent(
            Vaadlin().verticalLayout(spacing = true, margin = true) {
                label("Vaadin + Kotlin = Love :)")

                horizontalLayout(spacing = true) {
                    val lbl = label("")
                    val button = button("Press me") {
                        addClickListener {
                            lbl.setValue(it.getClientX().toString())
                        }
                    }

                    it.replaceComponent(lbl, button)
                }

                val notificationTextArea = textArea("Notification text")

                button("show notification") {
                    setIcon(FontAwesome.INFO)
                    addClickListener {
                        Notification.show(notificationTextArea.getValue(), Notification.Type.HUMANIZED_MESSAGE)
                    }
                }
            }
    )

}

