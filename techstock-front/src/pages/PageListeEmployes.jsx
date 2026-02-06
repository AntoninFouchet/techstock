// src/pages/PageListeEmployes.jsx
import { useEffect, useState } from 'react';
import EmployeeService from '../services/employeeService.js';
import '../App.css'; // Pour un peu de style basique

const PageListeEmployes = () => {
    // 1. Définir l'état (State)
    // employees : la liste des données
    // loading : pour afficher un message "Chargement..."
    const [employees, setEmployees] = useState([]);
    const [loading, setLoading] = useState(true);

    // 2. useEffect : Se lance au démarrage du composant
    useEffect(() => {
        EmployeeService.getAll()
            .then(response => {
                setEmployees(response.data); // On met à jour l'état avec les données Java
                setLoading(false);
            })
            .catch(error => {
                console.error("Erreur API", error);
                setLoading(false);
            });
    }, []); // Le tableau vide [] signifie : "Exécute ça une seule fois au montage"

    if (loading) return <p>Chargement des données...</p>;

    return (
        <div className="container">
            <h2>Annuaire TechStock</h2>
            <table border="1" cellPadding="10" style={{ width: '100%', borderCollapse: 'collapse' }}>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom Complet</th>
                    <th>Email</th>
                    <th>Poste</th>
                </tr>
                </thead>
                <tbody>
                {employees.map(emp => (
                    <tr key={emp.id}>
                        <td>{emp.id}</td>
                        <td>{emp.nomComplet}</td>
                        <td>{emp.email}</td>
                        <td>{emp.poste}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default PageListeEmployes;