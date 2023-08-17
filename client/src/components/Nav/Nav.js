import { Link } from 'react-router-dom';
import { Container, NavContainer, NavWrapper, Text } from './Nav.styled';
import { faEarthAmericas, faAward } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const nav = [
  {
    page: 'Questions',
    adress: '/',
  },
  {
    page: 'Tags',
    adress: '/',
  },
  {
    page: 'Users',
    adress: '/',
  },
  {
    page: 'Companies',
    adress: '/',
  },
];

function Nav() {
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
            className={idx === 0 && 'wrapper-withIcon'}
          >
            <Link to={nav.adress}>
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
        <NavWrapper className="wrapper-withIcon">
          <Link to="/">
            <FontAwesomeIcon icon={faAward} />
            <Text className="nav-list">Explore Collectives</Text>
          </Link>
        </NavWrapper>
      </NavContainer>
    </Container>
  );
}

export default Nav;
