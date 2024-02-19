document.addEventListener('DOMContentLoaded', function () {
    console.log(document.getElementById('topicDropdown'));
    document.getElementById('topicDropdown').addEventListener('change', function () {
        var selectedTopicId = this.value;
        getWordsByTopic(selectedTopicId);
    });

    function getWordsByTopic(topicId) {
        $.ajax({
            type: 'GET',
            url: '/nav/edit/getWordsByTopic?topicId=' + topicId,
            success: function (data) {
                populateTable(data);
            },
            error: function (error) {
                console.error('Error' + error);
            }
        });
    }

    function populateTable(data) {
        var tableBody = document.querySelector('#wordTable tbody');
        tableBody.innerHTML = '';
        console.log(data);

        data.forEach(function (word) {
            var row = tableBody.insertRow();

            var cell1 = row.insertCell(0);
            cell1.innerHTML = word.name;

            var cell2 = row.insertCell(1);

            var updateButton = document.createElement('button');
            console.log(word.id);
            updateButton.textContent = 'Update';
            updateButton.onclick = function () {
                window.location.href = '/word/update/showFormForUpdate/' + word.id;
            }
            cell2.appendChild(updateButton);

            var deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            deleteButton.onclick = function () {

                var confirmDelete = confirm('Are you sure you want to delete ' + word.name + '?');
                if (confirmDelete) {
                    console.log('Deleted button at id: ' + word.id);
                    window.location.href = '/word/delete/' + word.id;
                }
            }
            cell2.appendChild(deleteButton);
        });
    }
})
