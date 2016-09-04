# To-Do-Android-Material
Simple todo Android Application to learn Android Design Principles 

**To Do** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing,deleting an existing item and reminder of todo items using local notifications.

Submitted by: **Deep Mehta**

Time spent: **25** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [x] Persist the todo items [into SQLite](https://developer.android.com/training/basics/data-storage/databases.html)
* [x] Improve style of the todo items in the list [using a custom adapter](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html) and [using custom cardview](https://developer.android.com/training/material/lists-cards.html)
* [x] Add support for completion due dates for todo items (and display within listview item)
* [x] Using custom Dialog box for creating and editing Todo items, Creating Todo item user can set remainders and Editing Todo items user can mark them completed.
* [x] Add support for selecting the priority of each todo item such as High, Normal, Low prorities.
* [x] Tweak the style improving the UI / UX, based on [Android Material Design](https://developer.android.com/design/material/index.html)

The following **additional** features are implemented:

* [x] Reminder for Todo task items based on minutes, hours and days using [Alarm Manager](https://developer.android.com/reference/android/app/AlarmManager.html), [Broadcast Receiver](https://developer.android.com/reference/android/content/BroadcastReceiver.html) and [Notifications](https://developer.android.com/guide/topics/ui/notifiers/notifications.html)
* [x] UI animation using [Coordinator Layout](https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.html)
* [x] Swipe Refresh on Task items using [Swipe Refresh Layout](https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html)

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='https://github.com/deepmehtait/To-Do-Android-Material/blob/master/gifs/work.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

Local Notification of task:

<img src='https://github.com/deepmehtait/To-Do-Android-Material/blob/master/gifs/Notification.gif' title='Video Walkthrough-Notification' width='' alt='Video Walkthrough-Notification' />

Smooth scrolling and View animation:

<img src='https://github.com/deepmehtait/To-Do-Android-Material/blob/master/gifs/ViewAnimation.gif' title='Video Walkthrough-Animation' width='' alt='Video Walkthrough-Anitmation' />

## Notes

Database Schema
| ToDoID| ToDoTaskDetails|ToDoTaskPrority|ToDoTaskStatus|ToDoNotes|
| ------------- |:-------------:| -----:|---------------:|--------:|
| Unique ID for each Task|Task Details |Task Prority- High, Normal, Low | Completed? | Extra Notes |

ToDoID | ToDoTaskDetails | ToDoTaskPrority | ToDoTaskStatus | ToDoNotes |
--- | --- | --- | --- | --- |
Unique ID for each Task | Task Details | Task Prority- High, Normal, Low | Completed? | Extra Notes
`Int Primary Key` | `Stirng` | `String` | `String` | `String` |
