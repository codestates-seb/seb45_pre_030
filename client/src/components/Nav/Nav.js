import { Link, useLocation } from 'react-router-dom';
import { Container, NavContainer, NavWrapper, Text } from './Nav.styled';
import { faEarthAmericas, faAward } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const nav = [
  {
    page: 'Questions',
    url: '/',
  },
  {
    page: 'Tags',
    url: '/tags',
  },
  {
    page: 'Users',
    url: '/users',
  },
  {
    page: 'Companies',
    url: '/companies',
  },
];

function Nav() {
  const location = useLocation();
  return (
    <Container>
      <NavContainer>
        <NavWrapper>
          <Link to="/">
            <Text className="nav-list nav-group">Home</Text>
          </Link>
        </NavWrapper>
        <NavWrapper>
          <Text className="nav-group">PUBLIC</Text>
        </NavWrapper>
        {nav.map((nav, idx) => (
          <NavWrapper
            key={nav.page}
            className={`${idx === 0 ? 'wrapper-withIcon' : ''} ${
              location.pathname === nav.url ? 'nav-selected' : ''
            }`}
          >
            <Link to={nav.url} className={idx === 0 ? 'link-withIcon' : ''}>
              {idx === 0 && <FontAwesomeIcon icon={faEarthAmericas} />}
              <Text className={`nav-list ${idx !== 0 && 'nav-list-padding'}`}>
                {nav.page}
              </Text>
            </Link>
          </NavWrapper>
        ))}
        <NavWrapper>
          <Text className="nav-group">COLLECTIVES</Text>
        </NavWrapper>
        <NavWrapper
          className={`${
            location.pathname === '/collectives' ? 'nav-selected' : ''
          }`}
        >
          <Link to="/collectives" className="link-withIcon">
            <FontAwesomeIcon icon={faAward} />
            <Text className="nav-list">Explore Collectives</Text>
          </Link>
        </NavWrapper>
      </NavContainer>
    </Container>
  );
}

export default Nav;
