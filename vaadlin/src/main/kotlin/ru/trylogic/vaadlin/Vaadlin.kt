package ru.trylogic.vaadlin

import com.vaadin.ui.*

class Vaadlin(val container: ComponentContainer? = null)

fun initComponent<T : Component>(self: Vaadlin, component: T, init: Vaadlin.(T) -> Unit = {}): T {
    self.container?.addComponent(component)

    if (component is ComponentContainer) {
        Vaadlin(component).init(component)
    } else {
        self.init(component)
    }

    return component
}

fun Vaadlin.button(caption: String? = null, init: (Button.() -> Unit) = {}): Button {
    return initComponent(this, Button(caption)) {
        it.init()
    }
}

fun Vaadlin.label(caption: String?, init: (Label.() -> Unit) = {}): Label {
    return initComponent(this, Label(caption)) {
        it.init()
    }
}

fun Vaadlin.table(caption: String? = null, init: (Table.() -> Unit) = {}): Table {
    return initComponent(this, Table(caption)) {
        it.init()
    }
}

fun Vaadlin.textField(init: (TextField.() -> Unit) = {}): TextField {
    return initComponent(this, TextField()) {
        it.init()
    }
}

fun Vaadlin.textArea(value: String? = "", init: (TextArea.() -> Unit) = {}): TextArea {
    return initComponent(this, TextArea(null, value)) {
        it.init()
    }
}

fun Vaadlin.comboBox(init: (ComboBox.() -> Unit) = {}): ComboBox {
    return initComponent(this, ComboBox()) {
        it.init()
    }
}

fun Vaadlin.verticalLayout(spacing: Boolean = false, margin: Boolean = false, init: Vaadlin.(VerticalLayout) -> Unit): VerticalLayout {
    val result = VerticalLayout()
    result.setSpacing(spacing)
    result.setMargin(margin)

    return initComponent(this, result, init)
}

fun Vaadlin.horizontalLayout(spacing: Boolean = false, margin: Boolean = false, init: Vaadlin.(HorizontalLayout) -> Unit): HorizontalLayout {
    val result = HorizontalLayout()
    result.setSpacing(spacing)
    result.setMargin(margin)

    return initComponent(this, result, init)
}

fun Vaadlin.formLayout(spacing: Boolean = false, margin: Boolean = false, init: Vaadlin.(FormLayout) -> Unit): FormLayout {
    val result = FormLayout()
    result.setSpacing(spacing)
    result.setMargin(margin)

    return initComponent(this, result, init)
}