package de.woock.ddd.stattauto.reservierung.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.woock.ddd.stattauto.reservierung.entity.Reservierung;

public interface ReservierungsDao extends JpaRepository<Reservierung, Long> {

	Reservierung       findOneByReservierungsId(Long reservierungsid);
	List<Reservierung> findByMieter_MieterId(Long mieterId);
	List<Reservierung> findByMietObjekt_MietObjektId(Long mietObjektId);
	
	@Query("select count(r) from Reservierung r where r.mietObjekt.mietObjektId= :mietObjektId and  ((:von >= r.zeitraum.startZeit and :von < r.zeitraum.endZeit) or (:bis >= r.zeitraum.startZeit and :bis < r.zeitraum.endZeit))")
	int                reservierungsueberschneidungen(@Param("von") Date von, @Param("bis") Date bis, @Param("mietObjektId") Long mietObjektId);
}
