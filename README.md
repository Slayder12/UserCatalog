**Программа «Каталог пользователей»**

Написать программу, содержащую список пользователей.  

1. На главном экране необходимо создать **Toolbar** с заголовком **«Каталог пользователей»**.  
   2. Создать два поля ввода: имени и возраста.  
   3. Создать кнопку **«Сохранить»**.  
   4. Создать **ListView**, в который будут помещены созданные пользователи.  
   5. Создать меню с одним пунктом **«Exit».**  
   Описание работы программы:  
   После запуска приложения поля ввода заполняем данными: Имя и возраст. По нажатию кнопки **«Сохранить»** в **ListView** появляются созданные пользователи. Поля ввода при добавлении очищаются.  
   Пользователей можно удалять по нажатию на элемент списка с пользователем, которого нужно удалить.  
   При выборе пункта меню **«Exit»** приложение закрывается.  
   Для удобства работы необходимо создать класс **User** с конструктором, в котором содержатся свойства имени и возраста. Обратите внимание на то, что список, в котором будут хранится пользователи будет типа **User**.

Screenshots:
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/1-1.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/1-2.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/1-3.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/1-4.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/1-5.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/1-6.png)

**Доработка.**

Доработать приложение по удалению пользователей путем вызова диалогового окна при нажатии на элемент списка.
В дополнении к логике приложения необходимо создать:

1. Класс MyDialog, в котором создается диалоговое окно.
   В нем предложить пользователю подтверждение действия по удалению. В диалоговом окне содержатся две кнопки «Да» - подтверждение удаления «Нет» - отмена действия и закрытие диалогового окна.
2. Закрытие приложения выполнить через создание меню и одного пункта «Exit». По нажатию на него, происходит завершение работы приложения.

Screenshots:
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/2-1.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/2-2.png)
Update:
![](https://github.com/Slayder12/UserCatalog/blob/variant2/assets/3-1.png)

   **Здание SaveInstanceState**

Сохраняем список пользователей при повороте экрана.

На основании приложения «Каталог пользователей», техническое задание по созданию приложения находится в домашнем задании по теме ListView, необходимо дописать логику приложения, чтобы при повороте экрана созданный список был сохранен.

   Необходимо создать:

1. Класс UserViewModel, который будет содержать объект MutableLiveData().

2. В MainActivity создать и инициализировать экземпляр UserViewModel.

3. Подписать адаптер listView на изменения списка с помощью функции observe. Ему передается новый список, снова связывается listView с адаптером, обновляется адаптер с помощью notifyDataSetChanged().

4. Не забудьте, что в процессе сохранения введённых данных о пользователе по нажатию на кнопку, после добавления user в список, список передается объекту класса UserViewModel и адаптер снова обновляется.

Приложение необходимо сохранить проектом в удаленном репозитории, для проверки качества предоставить ссылку преподавателю, либо сделать скрины эмулятора при каждом шаге работы приложения.

Screenshots: 
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-1.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-2.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-3.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-4.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-5.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-6.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-7.png)
![](https://github.com/Slayder12/UserCatalog/blob/main/assets/4-8.png)
