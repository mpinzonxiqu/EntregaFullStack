import React, { useState } from 'react';
import axios from 'axios';

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.get(`https://api.github.com/search/users?q=${searchTerm}`);
      setUsers(response.data.items);
    } catch (error) {
      console.error('Error fetching data from GitHub', error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSearch}>
        <input
          type="text"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          placeholder="Busqueda de Usuarios GitHub"
        />
        <button type="submit">Buscar</button>
      </form>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            <img src={user.avatar_url} alt={user.login} width="50" />
            <a href={user.html_url} target="_blank" rel="noopener noreferrer">{user.login}</a>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UserList;
