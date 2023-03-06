const calendarForm = document.querySelector('.container-data form')
const today = moment(); // поточна дата
const firstDayOfMonth = moment(today).startOf('month'); // перший день поточного місяця
const lastDayOfMonth = moment(today).endOf('month'); // останній день поточного місяця
const daysInMonth = lastDayOfMonth.date(); // кількість днів у поточному місяці

let firstDayOfGrid = moment(firstDayOfMonth).startOf('week'); // перший день тижня, що міститься в сітці дат
let lastDayOfGrid = moment(lastDayOfMonth).endOf('week'); // останній день тижня, що міститься в сітці дат

// якщо перше число місяця припадає на вівторок, то переносимо останній день попереднього місяця на понеділок
if (firstDayOfMonth.day() === 2) {
    firstDayOfGrid = moment(firstDayOfMonth).subtract(1, 'week').startOf('week');
    lastDayOfGrid = moment(lastDayOfMonth).add(1, 'week').endOf('week');
}

const numDays = lastDayOfGrid.diff(firstDayOfGrid, 'days') + 1; // загальна кількість днів у сітці дат (42)

const dates = []; // масив, в який будуть додаватися всі дати в сітці дат

for (let i = 1; i < numDays + 1; i++) {
    const day = moment(firstDayOfGrid).add(i, 'days');
    dates.push(day);
}

console.log('Sun Mon Tue Wed Thu Fri Sat');
for (let i = 0; i < numDays; i++) {
    const date = dates[i];
    const isToday = date.isSame(today, 'day');
    const isCurrentMonth = date.isSame(firstDayOfMonth, 'month');
    console.log(date.format('D'))
    calendarForm.innerHTML += `<div>${date.format('D')}</div>`

}

console.log(dates)